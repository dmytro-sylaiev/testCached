pipeline {
    agent any
    tools {
            maven 'mvn3'
        }

    stages {
        stage('Build') {
            steps {
                sh """ mvn clean install -Dmaven.build.cache.enabled=true
                """

            }
        }
    }
}
