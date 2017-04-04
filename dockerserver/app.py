from flask import Flask, jsonify, request

app = Flask(__name__)

tasks = [
    {
        'id': 1,
        'data': u'message1'
    },
    {
        'id': 2,
        'data': u'message2'
    }
]

@app.route('/api/get', methods=['GET'])
def get_tasks():
    return jsonify({'tasks': tasks})

@app.route('/api/post', methods=['POST'])
def create_task():
    if not request.json or not 'data' in request.json:
        abort(400)
    task = {
        'id': tasks[-1]['id'] + 1,
        'data': request.json['data']
    }
    tasks.append(task)
    return jsonify({'task': task}), 201


@app.route('/api/update/<int:task_id>', methods=['PUT'])
def update_task(task_id):
    task = filter(lambda t: t['id'] == task_id, tasks)
    if len(task) == 0:
        abort(404)
    if not request.json:
        abort(400)
    if 'data' in request.json and type(request.json['data']) != unicode:
        abort(400)
    task[0]['data'] = request.json.get('data', task[0]['data'])
    return jsonify({'task': task[0]})



if __name__ == '__main__':
    app.run(debug = True)
