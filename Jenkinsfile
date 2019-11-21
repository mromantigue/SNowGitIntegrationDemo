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
def response = serviceNow_createChange serviceNowConfiguration: [instance: 'https://dev86178.service-now.com/', producerId: 'e0d2f9b4db110010b16ea3a948961974'], credentialsId: 'admin'
def jsonSlurper = new JsonSlurper()
def createResponse = jsonSlurper.parseText(response.content)
def sysId = createResponse.result.sys_id
def changeNumber = createResponse.result.number
}
}