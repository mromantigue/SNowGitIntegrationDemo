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
println "Approving change request"
println "Successfully moved the updates to PROD"
}
}