pipeline {
  agent any
  stages {
    stage('Hello') {
      steps {
        echo 'Hello'
      }
    }

    stage('Checkout code') {
        steps {
            checkout scm
        }
    }

    stage('Build') {
      steps {
        withGradle() {
          sh './gradlew build'
        }

      }
    }

    stage('Bye') {
      steps {
        echo 'Bye'
      }
    }

  }
}