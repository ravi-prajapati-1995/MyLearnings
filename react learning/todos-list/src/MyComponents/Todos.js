import Table from 'react-bootstrap/Table';
import TodoItem from './TodoItem';

export default function Todos({ todos, onDelete }) {

    return (
        <div>
            {todos.length == 0 ? 'Not Todos to display' :

                <Table striped bordered hover size="sm" responsive="sm">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {todos.map((todoItem, key) => (
                            <TodoItem item={todoItem} key={key} onDelete={onDelete}></TodoItem>
                        ))}
                    </tbody>
                </Table >
            }
        </div>
    )
}
