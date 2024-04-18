String build_cache_location = ''
final String pullRequestId = env.CHANGE_ID
final String branch_name = pullRequestId != null ? env.CHANGE_BRANCH : env.BRANCH_NAME
pipeline {
    agent any
    tools {
            maven 'mvn3'
    }

    parameters {
        booleanParam(
                  name: 'MAVEN_CACHE',
                  defaultValue: (pullRequestId != null),
                  description: '''
                    Use maven cache, only possible for branches with PR
                    ''')
    }

    stages {
        stage('Build') {
            steps {
                script {
                println 'Manage the MAVEN_CACHE option'
                    if (params.MAVEN_CACHE){
                        if (pullRequestId != null) {
                            build_cache_location = "/tmp/build_cache/$pullRequestId"
                            if (!fileExists(build_cache_location)) {
                                    sh """
                                        mkdir $build_cache_location
                                    """.stripIndent()
                                }
                            println '- MAVEN_CACHE content'
                            sh """
                                set -xe

                                ls -l /tmp/build_cache
                                ls -l $build_cache_location
                                """.stripIndent()

                            sh """ mvn clean install -Dmaven.build.cache.enabled=true -Dmaven.build.cache.location=$build_cache_location
                               """.stripIndent()
                        } else {
                            error("Maven cache requested on non PR branch, not allowed")
                        }
                    } else {
                    sh """ mvn clean install
                       """.stripIndent()
                    }
                }

            }
        }
    }
}
