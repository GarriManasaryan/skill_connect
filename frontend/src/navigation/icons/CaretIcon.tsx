import style from 'antd/es/alert/style';
import path from 'path'
import React from 'react'

interface ProductIconProps {
  hovered: boolean;
}

function CaretIcon({ hovered }: ProductIconProps) {
  return (
    <svg width="18" height="12" viewBox="0 0 12 9" fill="none"
    stroke={hovered ? "var(--text-hovered-color)" : "var(--text-color)"}
      style={{
        marginLeft: '2px',
        transform: hovered ? 'rotate(180deg)' : 'rotate(0deg)',
        transition: 'var(--transition)',
        fontFamily: 'Cantarell',
      }}
    >
      <path d="M6 1L11 8" stroke-linecap="round" 
        style={{
        transition: 'var(--transition)',
      }}
      />
      <path d="M1 8L6 1" stroke-linecap="round" 
        style={{
        transition: 'var(--transition)',
      }}
      />
    </svg>
  )
}

export default CaretIcon