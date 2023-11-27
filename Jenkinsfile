pipeline {
  agent any
  stages {
    stage('run maven project') {
      parallel {
        stage('run maven project') {
          steps {
            sh 'mvn clean install'
          }
        }

        stage('get version') {
          steps {
            sh 'mvn --version'
          }
        }

      }
    }

  }
}