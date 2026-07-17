import React from 'react'

export const Footer = () => {
  return (
    <div className="card sticky-bottom">
      <div className="card-header">
        Quote
      </div>
      <div className="card-body">
        <figure>
          <blockquote className="blockquote">
            <p>A well-known quote, contained in a blockquote element.</p>
          </blockquote>
          <figcaption className="blockquote-footer">
            Someone famous in <cite title="Source Title">Source Title</cite>
          </figcaption>
        </figure>
      </div>
    </div>
  )
}

