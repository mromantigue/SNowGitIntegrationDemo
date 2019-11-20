node {
stage ('SCM checkout'){
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
}
stage ('Build'){
dir("mavenproject1") {
sh "mvn clean install"
}
dir("mavenproject1/target") {
sh "java -jar mavenproject1-1.0-SNAPSHOT.jar"
}
}
}