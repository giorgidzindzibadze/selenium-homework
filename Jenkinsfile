pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout your branch
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/giorgidzindzibadze/Project2.git']]])
                }
            }
        }

        stage('Build and Get Version') {
            parallel {
                stage('Run Maven Project') {
                    steps {
                        script {
                            // Run Maven build
                            sh 'mvn clean install'
                        }
                    }
                }

                stage('Get Maven Version') {
                    steps {
                        script {
                            // Get Maven version
                            sh 'mvn --version'
                        }
                    }
                }
            }
        }
    }
}
