import EventSection from '@/components/EventSection'
import Header from '@/components/Header'
import Navbar from '@/components/Navbar'
import Section from '@/components/Section'
import axios from 'axios'
import { useEffect, useState } from 'react'

interface Event {
	id: number
	name: string
	description: string
	eventType: string
	dateTime: string
	link: string
}

export default function Home() {
	const [eventList, setEventList] = useState<Event[]>([])

	useEffect(() => {
		axios.get('/api/events/').then((res) => {
			setEventList(res.data)
		})
	}, [])

	return (
		<>
			<Navbar
				title="coolab"
				links={[
					{ to: 'home', text: 'Home' },
					{ to: 'events', text: 'Events' },
					{ to: 'about', text: 'About' },
					{ to: 'contact', text: 'Contact' },
				]}
			/>
			<Header
				title="It's The Great Art Theater"
				description="More Than Just a Theater"
			/>

			<EventSection name='Turlar' type='tour' eventList={eventList}/>
			<EventSection name='Konfranslar' type='conference' eventList={eventList}/>
			<EventSection name='Seminarlar' type='seminar' eventList={eventList}/>
			<EventSection name='Kurslar' type='course' eventList={eventList}/>
			<EventSection name='Vorkşoplar' type='workshop' eventList={eventList}/>
			<EventSection name='Xeyriyyə' type='charity' eventList={eventList}/>

			<Section title="About" background="#efefef">
				<div className="row">
					<div className="col-md-6">
						<p>
							The About page is the core description of your
							website. Here is where you let clients know what
							your website is about. You can edit all of this text
							and replace it with what you want to write. For
							example you can let them know how long you have been
							in business, what makes your company special, what
							are its core values and more.
							<br /> <br /> Edit your About page from the Pages
							tab by clicking the edit button.
						</p>
					</div>
					<div
						className="col-md-6"
						style={{ display: 'flex', justifyContent: 'center' }}
					>
						<div
							style={{
								width: '30vw',
								height: '30vw',
								background: '#ccc',
							}}
						></div>
					</div>
				</div>
			</Section>
			<Section title="Contact">
				<div className="col-md-12" id="contact-details">
					<a href="mailto:ruslankerimov2021@gmail.com">
						<i className="fa-solid fa-envelope"></i>{' '}
						ruslankerimov2021@gmail.com
					</a>
					<span>
						<i className="fa-solid fa-phone"></i> +994551234567
					</span>
					<span>
						<i className="fa-solid fa-location-dot"></i> Baku,
						Azerbaijan
					</span>
				</div>
			</Section>
		</>
	)
}
