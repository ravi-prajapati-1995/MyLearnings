import React from 'react'
import TodoItem from './TodoItem'
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import AddToDo from './AddToDo';

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
                        {todos.map((key, todoItem) => (
                            <TodoItem item={todoItem} key={key} onDelete={onDelete}></TodoItem>
                        ))}
                    </tbody>
                </Table >
            }
        </div>
    )
}
