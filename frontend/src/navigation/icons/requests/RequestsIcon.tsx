import path from 'path'
import React from 'react'
import IconProps from '../common/IconProps'

function RequestsIcon({ hovered, isActive }: IconProps) {

    const pathStyle = {
        transition: 'var(--transition)',
        strokeDasharray: 50, // Adjust based on path length for full coverage
        strokeDashoffset: hovered || isActive ? 0 : 50, // Full offset when not hovered, 0 when hovered
      };

    return (
        <svg className="feather feather-file-text" fill="none" height="24" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"
        stroke={hovered || isActive ? "var(--text-hovered-color)" : "var(--text-color)"}
        style={{transition: 'var(--transition)'}}
        >
            <path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"/>
            <polyline points="14 2 14 8 20 8" />
            <line x1="16" x2="8" y1="13" y2="13" style={pathStyle}/>
            <line x1="16" x2="8" y1="17" y2="17" style={pathStyle}/>
            <polyline points="10 9 9 9 8 9" style={pathStyle}/>
        </svg>
    )
}

export default RequestsIcon