pipeline {
    agent any

    stages {
        // Parar todos los servicios 
        stage('Parando los servicios') {
            steps {
                bat '''
                    docker-compose -p adj-demo down || true
                '''
            }
        }

        // Eliminar las imágenes anteriores
        stage('Borrando imágenes antiguas') {
            steps {
                bat '''
                    for /f "tokens=*" %%i in ('docker images --filter "label=com.docker.compose.project=demo" -q') do (
                        docker rmi -f %%i
                    )
                    if errorlevel 1 (
                        echo No hay imagenes por eliminar
                    ) else (
                        echo Imagenes eliminadas correctamente
                    )
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