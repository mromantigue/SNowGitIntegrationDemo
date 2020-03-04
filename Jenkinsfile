import groovy.json.JsonSlurper
node {
stage ('Code'){
println "STAGE: CODE"
println "Checking out repository..."
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
dir("mavenproject1") {
println "Initializing test script..."
bat "mvn clean install"
println "Creating new change record for movement to Production..."
def response = serviceNow_createChange serviceNowConfiguration: [instance: 'dev71415', producerId: 'ac6faea8db130010bbc253184b9619fa'], credentialsId: 'jenkins-vault', vaultConfiguration: [url: 'http://localhost:8080/', path: 'credentials/store/system/domain/_/']
def jsonSlurper = new JsonSlurper()
def createResponse = jsonSlurper.parseText(response.content)
def sysId = createResponse.result.sys_id
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
println "Approving change request"
println "Successfully moved the updates to PROD"
}
}