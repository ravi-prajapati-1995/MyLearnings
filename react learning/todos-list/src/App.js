
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './MyComponents/Header';
import Todos from './MyComponents/Todos';
import { Footer } from './MyComponents/Footer';
import { useState, useEffect } from 'react';

function App() {


  const onDelete = (todo) => {
    console.log("I am on delte", todo)
    setTodos(todos.filter(item => item !== todo))
  }

  const [todos, setTodos] = useState([
    {
      sno: 1,
      title: "Learn React",
      desc: "Understand components, props and state"
    },
    {
      sno: 2,
      title: "Build Todo App",
      desc: "Create add, delete and update functionality"
    },
    {
      sno: 3,
      title: "Practice DSA",
      desc: "Solve 2 problems daily"
    }
  ]);

  useEffect(() => {
    console.log("Effect running");
  }, [todos]);
  return (

    <>
      <Header name={123} searchBar={true}></Header>
      <Todos todos={todos} onDelete={onDelete}></Todos>
      <Footer></Footer>
    </>
  );
}

export default App;
