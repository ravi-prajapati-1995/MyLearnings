import Button from 'react-bootstrap/Button';


const TodoItem = ({ item, onDelete }) => {
  return (
    <>
      <tr>
        <td>{item.sno}</td>
        <td>{item.title}</td>
        <td>{item.desc}</td>
        <td><Button variant="danger" size="sm" onClick={() => onDelete(item)}>Danger</Button></td>
      </tr>
    </>
  );
}


export default TodoItem
