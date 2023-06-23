import React, { useEffect, useState } from 'react'
import Link from 'next/link'
import axios from 'axios'
import AdminWrapper from '@/components/AdminWrapper'

interface Event {
	id: number
	name: string
	description: string
	eventType: string
	dateTime: string
	link: string
}

const AdminPage: React.FC = () => {
	const [eventList, setEventList] = useState<Event[]>([])

	useEffect(() => {
		axios.get('/api/events/').then((res) => {
			setEventList(res.data)
		})
	}, [])

	return (
		<AdminWrapper>
			<table className="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Description</th>
						<th scope="col">Event Type</th>
						<th scope="col">Date</th>
						<th scope="col">Link</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					{eventList.map((event) => (
						<tr key={event.id}>
							<td>{event.id}</td>
							<td>{event.name}</td>
							<td>{event.description}</td>
							<td>{event.eventType}</td>
							<td>{event.dateTime}</td>
							<td>
								<a
									href={event.link}
									target="_blank"
									rel="noopener noreferrer"
								>
									{event.link}
								</a>
							</td>
							<td>
								<Link
									href={`/admin/modify_event/${event.id}`}
									legacyBehavior
								>
									<a className="btn btn-primary">Edit</a>
								</Link>
							</td>
						</tr>
					))}
				</tbody>
			</table>
		</AdminWrapper>
	)
}

export default AdminPage
