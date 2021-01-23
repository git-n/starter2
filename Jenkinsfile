pipeline {
    agent any

    stages {
        stage('Parallel Stage') {
            parallel {
                stage('User Info') {
                    steps {
                        sh 'id'
                    }
                }
                stage('Compile') {
                    steps {
                          sh './gradlew assemble'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                  sh './gradlew clean test'
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage('Code Analysis') {
            steps {
                sh './gradlew sonarqube'
            }
        }
        stage('Bye') {
            steps {
                echo 'Bye World'
            }
        }
    }
}
