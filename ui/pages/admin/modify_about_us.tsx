import axios from 'axios'
import Link from 'next/link'
import { useRouter } from 'next/router'
import { useEffect, useState } from 'react'

interface Event {
	id: number
	name: string
	description: string
	eventType: string
	dateTime: string
	link: string
	status: string
}

export default function ModifyAboutUs() {

	const sendRequest = () => {
		var data = new FormData()
		
		axios({
			method: 'post',
			url: '/api/events/',
			data: data,
			headers: { 'Content-Type': 'multipart/form-data' },
		}).then((d) => {
			if (d.status == 201) {
				window.open('/admin/', '_self')
			}
		})
	}

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
						</ul>
					</div>
				</div>
			</nav>

			<div className="container mt-4">
				<div className="create-event">
					
					<button
						className="btn btn-primary mt-4"
						onClick={() => {
							sendRequest()
						}}
					>
						Save
					</button>
				</div>
			</div>
		</div>
	)
}
