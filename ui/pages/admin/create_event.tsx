import AdminWrapper from '@/components/AdminWrapper'
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

export default function CreateEvent() {
	const router = useRouter()

	const [name, setName] = useState('')
	const [description, setDescription] = useState('')
	const [date, setDate] = useState('')
	const [link, setLink] = useState('')
	const [eventType, setEventType] = useState('')
	const [status, setStatus] = useState('')

	const sendRequest = () => {
		var data = new FormData()
		data.append('name', name)
		data.append('description', description)
		data.append('image', (document.getElementById('image') as any).files[0])
		data.append('date', date)
		data.append('link', link)
		data.append('eventType', eventType)
		data.append('status', status)

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
		<AdminWrapper>
			<div className="create-event">
				<div className="form-group">
					<label htmlFor="name">Name</label>
					<input
						placeholder="Name..."
						type="text"
						name="name"
						id="name"
						className="form-control"
						value={name}
						onChange={(e) => setName(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="description">Description</label>
					<input
						placeholder="Description..."
						type="text"
						name="description"
						id="description"
						className="form-control"
						value={description}
						onChange={(e) => setDescription(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="date">Date</label>
					<input
						placeholder="Date..."
						type="text"
						name="date"
						id="date"
						className="form-control"
						value={date}
						onChange={(e) => setDate(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="link">Link</label>
					<input
						placeholder="Link..."
						type="text"
						name="link"
						id="link"
						className="form-control"
						value={link}
						onChange={(e) => setLink(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="eventType">Event type</label>
					<select
						name="eventType"
						id="eventType"
						className="form-control"
						value={eventType}
						onChange={(e) => setEventType(e.target.value)}
					>
						<option value="tour">Tour</option>
						<option value="conference">Conference</option>
						<option value="seminar">Seminar</option>
						<option value="course">Course</option>
						<option value="workshop">Workshop</option>
						<option value="charity">Charity</option>
					</select>
				</div>
				<div className="form-group">
					<label htmlFor="status">Status</label>
					<input
						placeholder="Status..."
						type="text"
						name="status"
						id="status"
						className="form-control"
						value={status}
						onChange={(e) => setStatus(e.target.value)}
					/>
				</div>
				<div className="form-group">
					<label htmlFor="image">Image</label>
					<br />
					<input type="file" name="image" id="image" />
				</div>
				<button
					className="btn btn-primary mt-4"
					onClick={() => {
						sendRequest()
					}}
				>
					Create
				</button>
			</div>
		</AdminWrapper>
	)
}
