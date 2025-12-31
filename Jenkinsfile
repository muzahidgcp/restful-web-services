pipeline {
    agent any

    tools {
        maven 'mvn-3.9.12'
        jdk 'JDK-17'
    }

    environment {
        DOCKER_IMAGE = "muzahidgcp/restful-web-services"
        DOCKER_TAG   = "latest"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Workspace') {
            steps {
                sh '''
                    pwd
                    ls -la
                '''
            }
        }

        stage('Build with Maven') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
            }
        }
    }

    post {
        success {
            echo '✅ Build & Docker image successful'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}
