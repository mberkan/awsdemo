eval $(aws ecr get-login --region us-east-2 | sed 's/-e none//') #needs AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY envvars
./gradlew pushImage
ecs-cli configure --cluster awsdemo --region us-east-2
ecs-cli compose --file docker/awsdemo-compose.yml service down
sleep 30
ecs-cli compose --file docker/awsdemo-compose.yml service up

