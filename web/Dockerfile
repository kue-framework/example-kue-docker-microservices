FROM gradle:3.4-alpine
ADD . /opt/fibonacci-web
WORKDIR /opt/fibonacci-web
CMD ["gradle", "run", "--continuous"]