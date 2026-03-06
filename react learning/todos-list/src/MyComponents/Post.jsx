import React, { useEffect, useState } from 'react'

export default function Post() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setPosts(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <h4>Loading...</h4>;
  if (error) return <h4>Error: {error}</h4>;

  const userDetails = (e, userId) => {
    e.preventDefault()
    console.log("I am here", userId)
  }
  return (
    <div className="container mt-4">
      <h2 className="mb-4">Posts</h2>

      <div className="row">
        {posts.map((post) => (
          <div key={post.id} className="col-md-4 mb-4">
            <div className="card h-100 shadow-sm">
              <div className="card-body">
                <h5 className="card-title">{post.title}</h5>
                <p className="card-text">{post.body}</p>
              </div>
              <div class="card-body">
                <a href="#" class="card-link" onClick={(e) => userDetails(e, post.userId)}>User {post.userId}</a>
              </div>
            </div>
          </div>
        ))}
      </div>

    </div>
  )
}
