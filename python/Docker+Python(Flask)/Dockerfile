FROM ubuntu:16.04


RUN apt-get update && apt-get install -y curl

RUN apt-get install -y python-pip python-dev build-essential
RUN pip install flask
RUN pip install virtualenv

COPY . /app
WORKDIR /app


ENTRYPOINT ["python"]


EXPOSE 22 80

RUN virtualenv flask

CMD ["app.py"]

