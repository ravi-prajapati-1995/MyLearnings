
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './MyComponents/Header';
import Todos from './MyComponents/Todos';
import { Footer } from './MyComponents/Footer';
import { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MyForm from './MyComponents/MyForm';

function App() {

  const [todos, setTodos] = useState(() => {
    const stored = localStorage.getItem("todos");
    return stored ? JSON.parse(stored) : [];
  });

  const onDelete = (todo) => {
    setTodos(todos.filter(item => item !== todo))
  }

  const addTodo = (title, desc) => {
    let size = todos.length === 0 ? 1 : todos[todos.length - 1].sno + 1
    let newTodo = {
      sno: size,
      title: title,
      desc: desc
    }
    setTodos([...todos, newTodo])
  }

  // Here in useEffect we used todos in array, so that where there is change in todos then this method will be called
  useEffect(() => {
    localStorage.setItem("todos", JSON.stringify(todos))
  }, [todos]);

  return (
    <BrowserRouter>
      <Container fluid >
        <Row>
          <Header name={'ToDo App'} searchBar={true} addTodo={addTodo}></Header>
          <Routes>
            <Route path="/" element={<Todos todos={todos} onDelete={onDelete} />} />
            <Route path="/form" element={<MyForm />} />
          </Routes>
          <Footer></Footer>
        </Row>
      </Container>
    </BrowserRouter>
  );
}

export default App;
