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
}
}