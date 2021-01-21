pipeline {
  agent any
  stages {
    stage('Hello') {
      steps {
        echo 'Hello'
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