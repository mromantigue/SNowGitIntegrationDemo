import groovy.json.JsonSlurper
node {
stage ('SCM checkout'){
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
}
stage ('Build'){
dir("mavenproject1") {
bat "mvn clean install"
}
dir("mavenproject1/target") {
bat "java -jar mavenproject1-1.0-SNAPSHOT.jar"
}
def response = serviceNow_createChange serviceNowConfiguration: [instance: 'dev86178', producerId: 'e0d2f9b4db110010b16ea3a948961974'], credentialsId: 'jenkins-vault', vaultConfiguration: [url: 'http://localhost:8080/', path: 'credentials/store/system/domain/_/']
def jsonSlurper = new JsonSlurper()
def createResponse = jsonSlurper.parseText(response.content)
def sysId = createResponse.result.sys_id
def changeNumber = createResponse.result.number
}
}