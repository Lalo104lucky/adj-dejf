pipeline {
    agent any

    stages {
        // Parar todos los servicios 
        stage('Parando los servicios') {
            steps {
                bat '''
                    docker-compose -p adj-demo-c down || true
                '''
            }
        }

        // Eliminar las imágenes anteriores
        stage('Borrando imágenes antiguas') {
            steps {
                bat '''
                    IMAGES=$(docker images --filter "label=com.docker.compose.project=adj-demo-c" -q)
                    if [ -n '$IMAGES']; then
                        docker images rmi $IMAGES
                    else
                        echo 'No hay imágenes para borrar...'
                    fi
                '''
            }
        }

        // Bajar la actualización
        stage('Actualizando...') {
            steps {
                bat '''
                    checkout scm
                '''
            }
        }

        // Levantar y desplegar el proyecto
        stage('Contruyendo y desplegando...') {
            steps {
                bat '''
                    docker compose up --build -d
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado exitosamente.'
        }

        failure {
            echo 'Error al ejecutar el pipeline.'
        }
        always {
            echo 'Pipeline finalizado.'
        }
    }
}