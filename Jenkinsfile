pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                mvn clean install -Dmaven.build.cache.enabled=true
            }
        }
    }
}
