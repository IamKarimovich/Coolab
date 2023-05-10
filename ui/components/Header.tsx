import React, { FC } from 'react'

interface IHeader {
	title: string
	description: string
}

const Header: FC<IHeader> = ({ title, description }) => {
	return (
		<header>
			<h1>{title}</h1>
			<h2>{description}</h2>
		</header>
	)
}

export default Header
