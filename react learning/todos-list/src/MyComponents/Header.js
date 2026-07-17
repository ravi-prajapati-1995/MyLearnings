
import PropTypes from 'prop-types';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import AddToDo from './AddToDo';


function Header({ name, searchBar, addTodo }) {
    return (
        <Navbar expand="lg" className="bg-body-tertiary justify-content-between">
            <Container>
                <Navbar.Brand >{name}</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/form">Signup</Nav.Link>
                        <Nav.Link href="/posts">All Posts</Nav.Link>
                        <AddToDo addTodo={addTodo}/>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}


Header.propTypes = {
    name: PropTypes.string.isRequired,
    searchBar: PropTypes.bool.isRequired
};

export default Header