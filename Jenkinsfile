pipeline {
    agent any

    stages {
        stage('Build') {
            tool name: 'mvn3', type: 'maven'
            steps {
                sh """ mvn clean install
                """

            }
        }
    }
}
