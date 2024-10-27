import style from 'antd/es/alert/style';
import path from 'path'
import React from 'react'
import IconProps from '../common/IconProps';

function ProductIcon({ hovered }: IconProps) {
  const pathStyle = {
    transition: 'var(--transition)',
    strokeDasharray: 50, // Adjust based on path length for full coverage
    strokeDashoffset: hovered ? 0 : 50, // Full offset when not hovered, 0 when hovered
  };
  
  return (
    <svg className="feather feather-gift" fill="none" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
      height='26'
      width='26'
      stroke={hovered ? "var(--text-hovered-color)" : "var(--text-color)"}
      style={{
        transition: 'var(--transition)',
      }}
    >
        <polyline points="20 12 20 22 4 22 4 12"/>
        <rect height="5" width="20" x="2" y="7"/>
        <line x1="12" x2="12" y1="22" y2="7"
          style={pathStyle}
        />
        <path d="M12 7H7.5a2.5 2.5 0 0 1 0-5C11 2 12 7 12 7z" style={pathStyle}/>
        <path d="M12 7h4.5a2.5 2.5 0 0 0 0-5C13 2 12 7 12 7z" style={pathStyle}/>
    </svg>
  )
}

export default ProductIcon