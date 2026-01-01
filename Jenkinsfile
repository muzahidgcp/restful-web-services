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
                sh '''
                    export PATH=/opt/homebrew/bin:/usr/local/bin:$PATH
                    docker --version
                    docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .
                '''
            }
        }

        stage('Docker Login & Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        export PATH=/opt/homebrew/bin:/usr/local/bin:$PATH
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${DOCKER_IMAGE}:${DOCKER_TAG}
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build, Docker image creation & push successful'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}

