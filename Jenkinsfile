pipeline {
    agent any
    tool name: 'mvn3', type: 'maven'

    stages {
        stage('Build') {
            steps {
                sh """ mvn clean install
                """

            }
        }
    }
}
