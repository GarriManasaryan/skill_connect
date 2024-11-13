import React from 'react'

function ProductsMain() {
  return (
    <div className='products-main' style={{
      display: 'grid',
      gridTemplateColumns: '1fr 3fr',
      gap: '40px',
      margin: '3rem 3rem 1.5rem 3rem',
    }}>
      <div className='products-main-filters' style={{
        border: '1px solid white', 
        height: '650px', 
        backgroundImage: 'var(--bg-image)'
        }}>Filters</div>
      <div className='products-main-cards' style={{
        border: '1px solid white', 
        backgroundImage: 'var(--bg-image)'
        }}>Cards</div>
    </div>
  )
}

export default ProductsMain