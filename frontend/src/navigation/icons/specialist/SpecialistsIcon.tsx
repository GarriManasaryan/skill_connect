import path from 'path'
import React from 'react'
import IconProps from '../common/IconProps'

function SpecialistsIcon({ hovered }: IconProps) {

    const pathStyle = {
        transition: 'var(--transition)',
        strokeDasharray: 50, // Adjust based on path length for full coverage
        strokeDashoffset: hovered ? 0 : 50, // Full offset when not hovered, 0 when hovered
      };

    return (
    <svg className="feather feather-users" fill="none" height="24" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"
    stroke={hovered ? "var(--text-hovered-color)" : "var(--text-color)"}
    style={{transition: pathStyle.transition}}
    >
        <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"/>
        <circle cx="9" cy="7" r="4"/>
        <path d="M23 21v-2a4 4 0 0 0-3-3.87" style={pathStyle}/>
        <path d="M16 3.13a4 4 0 0 1 0 7.75" style={pathStyle}/>
    </svg>
    )
}

export default SpecialistsIcon