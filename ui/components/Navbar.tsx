import React, { FC } from 'react'

interface INavbar {
	title: string
	links: { to: string; text: string }[]
}

const Navbar: FC<INavbar> = ({ title, links }) => {
	return (
		<nav className="navbar navbar-expand-lg fixed-top">
			<div className="container-fluid">
				<a className="navbar-brand" href="#">
					{title}
				</a>
				<button
					className="navbar-toggler"
					type="button"
					data-bs-toggle="collapse"
					data-bs-target="#navbarNav"
					aria-controls="navbarNav"
					aria-expanded="false"
					aria-label="Toggle navigation"
				>
					<span className="navbar-toggler-icon"></span>
				</button>
				<div className="collapse navbar-collapse" id="navbarNav">
					<ul className="navbar-nav">
						{links.map((i, index) => (
							<li className="nav-item" key={index}>
								<a className="nav-link" href="#">
									{i.text}
								</a>
							</li>
						))}
					</ul>
				</div>
			</div>
		</nav>
	)
}

export default Navbar
