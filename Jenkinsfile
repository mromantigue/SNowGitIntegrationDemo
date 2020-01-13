import groovy.json.JsonSlurper
node {
stage ('Code'){
println "STAGE: CODE"
println "Checking out repository..."
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
dir("mavenproject1") {
println "Initializing test script..."
bat "mvn clean install"
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
println "Creating new change record for movement to Production..."
def response = serviceNow_createChange serviceNowConfiguration: [instance: 'dev70481', producerId: 'e0d2f9b4db110010b16ea3a948961974'], credentialsId: 'jenkins-vault', vaultConfiguration: [url: 'http://localhost:8080/', path: 'credentials/store/system/domain/_/']
def jsonSlurper = new JsonSlurper()
def createResponse = jsonSlurper.parseText(response.content)
def sysId = createResponse.result.sys_id
def changeNumber = createResponse.result.number
println "Successfully created new CHANGE RECORD: " + changeNumber
}
}