import Link from 'next/link'
import React, { FC } from 'react'

const AdminWrapper: FC<any> = ({ children }) => {
	return (
		<div className="admin-container">
			<nav className="admin-nav navbar navbar-expand-lg navbar-dark bg-dark">
				<div className="container">
					<Link href="/admin" legacyBehavior>
						<a className="navbar-brand">Coolab Admin</a>
					</Link>
					<div
						className="collapse navbar-collapse"
						id="navbarSupportedContent"
					>
						<ul className="navbar-nav ml-auto">
							<li className="nav-item">
								<Link href="/admin/create-event" legacyBehavior>
									<a className="nav-link">Create New Event</a>
								</Link>
							</li>
							<li className="nav-item">
								<Link href="/admin/create_event" legacyBehavior>
									<a className="nav-link">Modify About Us</a>
								</Link>
							</li>
						</ul>
					</div>
				</div>
			</nav>

			<div className="container mt-4">{children}</div>
		</div>
	)
}

export default AdminWrapper