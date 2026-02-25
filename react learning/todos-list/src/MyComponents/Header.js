
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import PropTypes from 'prop-types'
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import AddToDo from './AddToDo';
import { useEffect } from 'react';


function Header({ name, searchBar, addTodo }) {
    return (
        <Navbar expand="lg" className="bg-body-tertiary justify-content-between">
            <Container>
                <Navbar.Brand >{name}</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="#home">Home</Nav.Link>
                        <Nav.Link href="#link">Signup</Nav.Link>
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