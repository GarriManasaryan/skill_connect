import IconProps from '../common/IconProps'

function BusinessesIcon({ hovered }: IconProps) {

    const pathStyle = {
        transition: 'var(--transition)',
        strokeDasharray: 200, // Adjust based on path length for full coverage
        strokeDashoffset: hovered ? 0 : 200, // Full offset when not hovered, 0 when hovered
    };

    return (
        <svg width="38" height="38" viewBox="0 0 141 113" fill="none" xmlns="http://www.w3.org/2000/svg"
        stroke={hovered ? "var(--text-hovered-color)" : "var(--text-color)"}
        style={{
          transition: pathStyle.transition,
        }}
        >
            {/* left building */}
            <path d="M3 42L3 110" stroke-width="5" stroke-linecap="round"/>
            <path d="M36 10L3 42" stroke-width="5" stroke-linecap="round"/>
            <path d="M27 46H14" stroke-width="5" stroke-linecap="round"/>
            <path d="M27 60H14" stroke-width="5" stroke-linecap="round"/>
            <path d="M27 73H14" stroke-width="5" stroke-linecap="round"/>
            <path d="M27 86H14" stroke-width="5" stroke-linecap="round"/>
            <path d="M27 99H14" stroke-width="5" stroke-linecap="round"/>
            <path d="M36 110H3" stroke-width="5" stroke-linecap="round"/>
            {/* right building */}
            <path d="M138 67L138 110" style={pathStyle} stroke-width="5" stroke-linecap="round"/>
            <path d="M111 35L138 67" style={pathStyle} stroke-width="5" stroke-linecap="round"/>
            <path d="M111 110H138" style={pathStyle} stroke-width="5" stroke-linecap="round"/>
            <circle style={pathStyle}  cx="123" cy="67" r="5" fill="none" stroke-width="3"/>
            <circle style={pathStyle} cx="123" cy="83" r="5" fill="none" stroke-width="3"/>
            <circle style={pathStyle} cx="123" cy="99" r="5" fill="none" stroke-width="3"/>
            <path d="M111 16L111 109" stroke-width="5" stroke-linecap="round"/>
            <path d="M94 29L94 45" stroke-width="5" stroke-linecap="round"/>
            <path d="M94 57L94 73" stroke-width="5" stroke-linecap="round"/>
            <path d="M94 84L94 100" stroke-width="5" stroke-linecap="round"/>
            <path d="M111 16L80 16" stroke-width="5" stroke-linecap="round"/>
            <path d="M36 3L36 110" stroke-width="5" stroke-linecap="round"/>
            <path d="M78 3L78 110" stroke-width="5" stroke-linecap="round"/>
            <path d="M111 110H78" stroke-width="5" stroke-linecap="round"/>
            <path d="M78 110H36" stroke-width="5" stroke-linecap="round"/>
            <path d="M78 3L36 3" stroke-width="5" stroke-linecap="round"/>
            <rect x="46.5" y="18.5" width="22" height="19" rx="3.5" stroke-width="3" stroke-linejoin="round"/>
            <rect x="46.5" y="47.5" width="22" height="19" rx="3.5" stroke-width="3" stroke-linejoin="round"/>
            <rect x="46.5" y="75.5" width="22" height="20" rx="3.5" stroke-width="3" stroke-linejoin="round"/>
        </svg>
    )
}

export default BusinessesIcon