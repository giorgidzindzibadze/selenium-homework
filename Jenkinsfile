pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout your branch
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/giorgidzindzibadze/selenium-homework.git']]])
                }
            }
        }

        stage('Build and Get Version') {
            parallel {
                stage('Run Maven Project') {
                    steps {
                        script {
                            // Run Maven build using bat
                            bat 'mvn clean install'
                        }
                    }
                }

                stage('Get Maven Version') {
                    steps {
                        script {
                            // Get Maven version using bat
                            bat 'mvn --version'
                        }
                    }
                }
            }
        }
    }
}
