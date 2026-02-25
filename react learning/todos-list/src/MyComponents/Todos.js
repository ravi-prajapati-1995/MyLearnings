import React from 'react'
import TodoItem from './TodoItem'
import Table from 'react-bootstrap/Table';

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
                        {todos.map((todoItem) => (
                            <TodoItem item={todoItem} key={todoItem.sno} onDelete={onDelete}></TodoItem>
                        ))}
                    </tbody>
                </Table >
            }
        </div>
    )
}
