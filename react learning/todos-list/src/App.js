
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './MyComponents/Header';
import Todos from './MyComponents/Todos';
import { Footer } from './MyComponents/Footer';
import { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function App() {

  let existingToDos = []
  if(localStorage.getItem("todos") != null) {
    const fromStorage = localStorage.getItem("todos");
    console.log("from local storage", fromStorage)
    existingToDos = JSON.parse(fromStorage)
  }

  const onDelete = (todo) => {
    console.log("I am on delte", todo)
    setTodos(todos.filter(item => item !== todo))
  }

  const addTodo = (title, desc) => {
    console.log('I am in add todo', title, desc)
    let size = todos.length ==0 ? 1 : todos[todos.length - 1].sno + 1
    let newTodo = {
      sno: size,
      title: title,
      desc: desc
    }
    setTodos([...todos, newTodo])
    localStorage.setItem("todos", JSON.stringify(todos))
  }

  const [todos, setTodos] = useState([existingToDos]);

  useEffect(() => {
    console.log("Effect running");

    return () => {
      console.log("I am in return ")
    }
  }, [todos]);

  return (

    <Container fluid >
      <Row>
        <Header name={'ToDo App'} searchBar={true} addTodo={addTodo}></Header>
        <Todos todos={todos} onDelete={onDelete}></Todos>
        <Footer></Footer>
      </Row>
    </Container>
  );
}

export default App;
