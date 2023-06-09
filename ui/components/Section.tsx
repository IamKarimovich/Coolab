import React, { FC, ReactNode } from 'react'

interface ISection {
	title: string
	children: ReactNode | ReactNode[]
	background?: string
}

const Section: FC<ISection> = ({ title, children, background = 'white' }) => {
	return (
		<section style={{ background: background }}>
			<h1>{title}</h1>
			<div className="container-fluid">{children}</div>
		</section>
	)
}

export default Section
