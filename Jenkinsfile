pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }

    environment {
        APP_NAME = "restful-web-services"
        DOCKER_IMAGE = "muzahidgcp/restful-web-services"
        DOCKER_TAG = "latest"
    }

    stages {

        stage('Checkout Code') {
		    steps {
		        sh 'ls -la'
		    }
		}

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                  docker build -t $DOCKER_IMAGE:$DOCKER_TAG .
                '''
            }
        }

        stage('Docker Image Info') {
            steps {
                sh 'docker images | grep restful-web-services'
            }
        }
    }

    post {
        success {
            echo '✅ Build and Docker image creation successful'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}
