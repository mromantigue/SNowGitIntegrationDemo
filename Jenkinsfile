node {
stage ('SCM checkout'){
git "https://github.com/mromantigue/SNowGitIntegrationDemo"
}
dir("mavenproject1/target") {
sh "java -jar mavenproject1-1.0-SNAPSHOT.jar"
}
}
}