import groovy.json.*
node {
stage ('Code'){
println "STAGE: CODE"
println "Checking out repository..."
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
String[] files = getChangedFilesList()
filename = files[0]
println filename
println filename.substring(filename.indexOf("-"), filename.indexOf("."));
dir("mavenproject1") {
println "Initializing test script..."
bat "mvn clean install"
println "Creating new change record for movement to Production..."
def response = serviceNow_createChange serviceNowConfiguration: [instance: 'dev71415', producerId: 'ac6faea8db130010bbc253184b9619fa'], credentialsId: 'jenkins-vault', vaultConfiguration: [url: 'http://localhost:8080/', path: 'credentials/store/system/domain/_/']
def jsonSlurper = new JsonSlurper()
def createResponse = jsonSlurper.parseText(response.content)
sysId = createResponse.result.sys_id
def changeNumber = createResponse.result.number
println "Successfully created new CHANGE RECORD: " + changeNumber
}
}
stage ('Test'){
println "STAGE: TEST"
dir("mavenproject1/target") {
println "Running selenium tests using chrome driver..."
bat "java -jar mavenproject1-1.0-SNAPSHOT.jar"
}
}
stage ('Release'){
println "STAGE: RELEASE"
println "Approving change request. The change request is now in Implement state."
def response = serviceNow_updateChangeItem serviceNowConfiguration: [instance: 'dev71415'], credentialsId: 'jenkins-vault', serviceNowItem: [table: 'change_request', sysId: sysId, body: '{"state":"-1"}'], vaultConfiguration: [url: 'http://localhost:8080/', path: 'credentials/store/system/domain/_/']
println "Successfully moved the updates to PROD"
}
}

// returns a list of changed files
@NonCPS
String getChangedFilesList() {

    changedFiles = []
    for (changeLogSet in currentBuild.changeSets) { 
        for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
            for (file in entry.getAffectedFiles()) {
                changedFiles.add(file.getPath().toString()) // add changed file to list
            }
        }
    }

    return changedFiles

}