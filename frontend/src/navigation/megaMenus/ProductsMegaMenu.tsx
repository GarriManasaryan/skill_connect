import React from 'react'



function ProductsMegaMenu() {


  return (
    <div className='products-mega-menu' style={{
      backgroundColor: 'var(--bg-color-level1)',
      marginTop: '1px',
      borderRadius: '25px',
      padding: '20px',
      transition: 'var(--transition)',

    }}
    >
            <div className='products-mega-menu-col-header'>Electronics</div>
            <div className='products-mega-menu-col-item'>Mobile Phones</div>
            <div className='products-mega-menu-col-item'>Laptops</div>
            <div className='products-mega-menu-col-item'>Tablets</div>
            <div className='products-mega-menu-col-item'>Televisions</div>
            <div className='products-mega-menu-col-item'>Cameras</div>
            <div className='products-mega-menu-col-item'>Headphones</div>
            <div className='products-mega-menu-col-item'>Smart Watches</div>
            <div className='products-mega-menu-col-header'>Fashion</div>
    </div>
  )
}

export default ProductsMegaMenu